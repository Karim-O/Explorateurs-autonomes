package process;

import data.map.geometry.Block;
import data.map.geometry.Position;

/**
 * This class. It controls the entry and the exit for the block.
 * 
 * @author Omar CHAKER
 * @author Feriel MALEK
 */
public class BlockManager {
	private Block block;
	private MobileElementManager occupyingMobileElement = null;

	public BlockManager(Block block) {
		this.block = block;
	}

	/**
	 * The "synchronized" keyword ensure unique access.
	 */
	public synchronized void enter(MobileElementManager manager) {
		if (occupyingMobileElement != null) {
			manager.getCharacter().setPosition(new Position(block.getX(), block.getY()));
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}

		BlockManager previousBlockManager = manager.getBlockManager();
		previousBlockManager.exit();

		manager.setBlockManager(this);
		occupyingMobileElement = manager;
	}

	public synchronized void exit() {
		occupyingMobileElement = null;
		
		notify();
	}

	public boolean isFree() {
		return occupyingMobileElement == null;
	}

	public Block getBlock() {
		return block;
	}
}
