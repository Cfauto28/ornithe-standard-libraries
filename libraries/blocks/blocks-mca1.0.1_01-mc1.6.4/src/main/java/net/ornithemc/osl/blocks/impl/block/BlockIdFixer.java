package net.ornithemc.osl.blocks.impl.block;

import ext.block.ExtBlock;
import net.ornithemc.osl.registries.api.registry.sync.IdFixer;

public class BlockIdFixer implements IdFixer {

	@Override
	public void apply() {
		for (int id = 0; id < ExtBlock.BY_ID.length; id++) {
			ExtBlock block = ExtBlock.BY_ID[id];

			if (block != null) {
				block.id = id;
			}
		}
	}
}
