package process;

import data.map.geometry.Block;
import data.map.geometry.Position;

/**
 * The block controller class. It controls the entry and the exit of train for the block.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class BlockManager {
	private Block block;
	private MobileElementManager occupyingMobileElement = null;

	public BlockManager(Block block) {
		this.block = block;
	}

	/**
	 * Tries to make a train enter into to the block. If the block is not free, the train should wait.
	 * The "synchronized" keyword ensure unique access.
	 * 
	 * @param trainManager the train asking for entry.
	 */
	public synchronized void enter(MobileElementManager manager) {
		if (occupyingMobileElement != null) {
			// The train asking for entry should wait until the block is freed by its occupying train.
			manager.getCharacter().setPosition(new Position(block.getX(), block.getY()));
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}

		// The train leaves and frees its previous block.
		BlockManager previousBlockManager = manager.getBlockManager();
		previousBlockManager.exit();

		// The train entries into this block.
		manager.setBlockManager(this);
		occupyingMobileElement = manager;
	}

	/**
	 * Makes the occupying train leave and notifies the waiting train.
	 */
	public synchronized void exit() {
		occupyingMobileElement = null;
		
		// Notify the waiting train (which can enter into the block now).
		notify();
	}

	public boolean isFree() {
		return occupyingMobileElement == null;
	}

	public Block getBlock() {
		return block;
	}
}
