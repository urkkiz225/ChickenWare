package me.ionar.salhack.module.fun;

import me.ionar.salhack.module.Module;
import me.ionar.salhack.module.Value;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;



public class IcyBlocksModule extends Module {
	public IcyBlocksModule()
    {
        super("IcyBlocks", new String[]
                        { "Icy Blocks" }, "Makes all the blocks slippery", "NONE",
                0xDB2485, Module.ModuleType.FUN);
    }
	public final Value<Float> Slipperiness = new Value<Float>("Block Slipperiness", new String[]
		    { "BlkSp" }, "Slipperiness of the blocks, default is 0.98 for ice", 0.6f, 0.0f, 10f, 0f); 
	public final Value<Boolean> DefaultSlipperiness = new Value<Boolean>("DefaulSlipperiness", new String[] {"EE"}, "Sets the slipperiness of blocks to the default 0.98.", false);
	
	
	@Override
	public void onEnable() {
	if (mc.player!=null) {
		if (mc.player.getRidingEntity() != null) {
			toggle();
		}
	}
	
	if (DefaultSlipperiness.getValue()) {
		Slipperiness.setValue(0.98f);
	}
		super.onEnable();
	              Blocks.COBBLESTONE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PACKED_ICE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.STONE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GRASS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DIRT.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.COBBLESTONE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PLANKS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BEDROCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SAND.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GRAVEL.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GOLD_ORE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.IRON_ORE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.COAL_ORE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LOG.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LOG2.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LEAVES.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LEAVES2.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SPONGE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GLASS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LAPIS_ORE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LAPIS_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DISPENSER.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SANDSTONE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.NOTEBLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BED.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PISTON.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PISTON_HEAD.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.WOOL.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PISTON_EXTENSION.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GOLD_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.IRON_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DOUBLE_STONE_SLAB.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.STONE_SLAB.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BRICK_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.TNT.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BOOKSHELF.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.MOSSY_COBBLESTONE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.OBSIDIAN.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.MOB_SPAWNER.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.OAK_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CHEST.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DIAMOND_ORE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DIAMOND_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CRAFTING_TABLE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.FARMLAND.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.FURNACE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LIT_FURNACE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.STONE_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.REDSTONE_ORE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SNOW_LAYER.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.ICE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SNOW.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CACTUS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CLAY.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.JUKEBOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.OAK_FENCE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SPRUCE_FENCE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BIRCH_FENCE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.JUNGLE_FENCE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DARK_OAK_FENCE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.ACACIA_FENCE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PUMPKIN.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.NETHERRACK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SOUL_SAND.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GLOWSTONE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LIT_PUMPKIN.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CAKE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.TRAPDOOR.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.MONSTER_EGG.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.STONEBRICK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BROWN_MUSHROOM_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.RED_MUSHROOM_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.IRON_BARS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GLASS_PANE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.MELON_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BRICK_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.STONE_BRICK_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.MYCELIUM.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.NETHER_BRICK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.NETHER_BRICK_FENCE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.NETHER_BRICK_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.ENCHANTING_TABLE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BREWING_STAND.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CAULDRON.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.END_PORTAL_FRAME.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.END_STONE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DRAGON_EGG.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.REDSTONE_LAMP.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LIT_REDSTONE_LAMP.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DOUBLE_WOODEN_SLAB.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.WOODEN_SLAB.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SANDSTONE_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.EMERALD_ORE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.ENDER_CHEST.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.EMERALD_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SPRUCE_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BIRCH_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.JUNGLE_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.COMMAND_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BEACON.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.COBBLESTONE_WALL.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.FLOWER_POT.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SKULL.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.ANVIL.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.TRAPPED_CHEST.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DAYLIGHT_DETECTOR.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DAYLIGHT_DETECTOR_INVERTED.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.REDSTONE_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.QUARTZ_ORE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.HOPPER.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.QUARTZ_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.QUARTZ_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DROPPER.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.STAINED_HARDENED_CLAY.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BARRIER.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.IRON_TRAPDOOR.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.HAY_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CARPET.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.HARDENED_CLAY.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.COAL_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PACKED_ICE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.ACACIA_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DARK_OAK_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SLIME_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.STAINED_GLASS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.STAINED_GLASS_PANE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PRISMARINE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SEA_LANTERN.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.STANDING_BANNER.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.RED_SANDSTONE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.RED_SANDSTONE_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.DOUBLE_STONE_SLAB2.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.STONE_SLAB2.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.END_ROD.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PURPUR_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PURPUR_PILLAR.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PURPUR_STAIRS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PURPUR_DOUBLE_SLAB.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PURPUR_SLAB.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.END_BRICKS.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GRASS_PATH.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.REPEATING_COMMAND_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CHAIN_COMMAND_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.FROSTED_ICE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.MAGMA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.NETHER_WART_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks. RED_NETHER_BRICK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BONE_BLOCK.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.OBSERVER.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.WHITE_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.ORANGE_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.MAGENTA_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LIGHT_BLUE_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.YELLOW_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LIME_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PINK_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GRAY_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SILVER_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CYAN_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PURPLE_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BLUE_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BROWN_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GREEN_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.RED_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BLACK_SHULKER_BOX.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.WHITE_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.ORANGE_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.MAGENTA_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.YELLOW_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.LIME_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PINK_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GRAY_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.SILVER_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CYAN_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.PURPLE_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BLUE_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BROWN_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.GREEN_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.RED_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.BLACK_GLAZED_TERRACOTTA.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CONCRETE.setDefaultSlipperiness(Slipperiness.getValue());
	              Blocks.CONCRETE_POWDER.setDefaultSlipperiness(Slipperiness.getValue());
				}
	@Override
	public void onDisable() {
		super.onDisable();
		  Blocks.AIR.setDefaultSlipperiness(0.6f);
          Blocks.COBBLESTONE.setDefaultSlipperiness(0.6f);
          Blocks.PACKED_ICE.setDefaultSlipperiness(0.6f);
          Blocks.STONE.setDefaultSlipperiness(0.6f);
          Blocks.GRASS.setDefaultSlipperiness(0.6f);
          Blocks.DIRT.setDefaultSlipperiness(0.6f);
          Blocks.COBBLESTONE.setDefaultSlipperiness(0.6f);
          Blocks.PLANKS.setDefaultSlipperiness(0.6f);
          Blocks.BEDROCK.setDefaultSlipperiness(0.6f);
          Blocks.SAND.setDefaultSlipperiness(0.6f);
          Blocks.GRAVEL.setDefaultSlipperiness(0.6f);
          Blocks.GOLD_ORE.setDefaultSlipperiness(0.6f);
          Blocks.IRON_ORE.setDefaultSlipperiness(0.6f);
          Blocks.COAL_ORE.setDefaultSlipperiness(0.6f);
          Blocks.LOG.setDefaultSlipperiness(0.6f);
          Blocks.LOG2.setDefaultSlipperiness(0.6f);
          Blocks.LEAVES.setDefaultSlipperiness(0.6f);
          Blocks.LEAVES2.setDefaultSlipperiness(0.6f);
          Blocks.SPONGE.setDefaultSlipperiness(0.6f);
          Blocks.GLASS.setDefaultSlipperiness(0.6f);
          Blocks.LAPIS_ORE.setDefaultSlipperiness(0.6f);
          Blocks.LAPIS_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.DISPENSER.setDefaultSlipperiness(0.6f);
          Blocks.SANDSTONE.setDefaultSlipperiness(0.6f);
          Blocks.NOTEBLOCK.setDefaultSlipperiness(0.6f);
          Blocks.BED.setDefaultSlipperiness(0.6f);
          Blocks.PISTON.setDefaultSlipperiness(0.6f);
          Blocks.PISTON_HEAD.setDefaultSlipperiness(0.6f);
          Blocks.WOOL.setDefaultSlipperiness(0.6f);
          Blocks.PISTON_EXTENSION.setDefaultSlipperiness(0.6f);
          Blocks.GOLD_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.IRON_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.DOUBLE_STONE_SLAB.setDefaultSlipperiness(0.6f);
          Blocks.STONE_SLAB.setDefaultSlipperiness(0.6f);
          Blocks.BRICK_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.TNT.setDefaultSlipperiness(0.6f);
          Blocks.BOOKSHELF.setDefaultSlipperiness(0.6f);
          Blocks.MOSSY_COBBLESTONE.setDefaultSlipperiness(0.6f);
          Blocks.OBSIDIAN.setDefaultSlipperiness(0.6f);
          Blocks.MOB_SPAWNER.setDefaultSlipperiness(0.6f);
          Blocks.OAK_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.CHEST.setDefaultSlipperiness(0.6f);
          Blocks.DIAMOND_ORE.setDefaultSlipperiness(0.6f);
          Blocks.DIAMOND_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.CRAFTING_TABLE.setDefaultSlipperiness(0.6f);
          Blocks.FARMLAND.setDefaultSlipperiness(0.6f);
          Blocks.FURNACE.setDefaultSlipperiness(0.6f);
          Blocks.LIT_FURNACE.setDefaultSlipperiness(0.6f);
          Blocks.STONE_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.REDSTONE_ORE.setDefaultSlipperiness(0.6f);
          Blocks.SNOW_LAYER.setDefaultSlipperiness(0.6f);
          Blocks.ICE.setDefaultSlipperiness(0.98f);
          Blocks.SNOW.setDefaultSlipperiness(0.6f);
          Blocks.CACTUS.setDefaultSlipperiness(0.6f);
          Blocks.CLAY.setDefaultSlipperiness(0.6f);
          Blocks.JUKEBOX.setDefaultSlipperiness(0.6f);
          Blocks.OAK_FENCE.setDefaultSlipperiness(0.6f);
          Blocks.SPRUCE_FENCE.setDefaultSlipperiness(0.6f);
          Blocks.BIRCH_FENCE.setDefaultSlipperiness(0.6f);
          Blocks.JUNGLE_FENCE.setDefaultSlipperiness(0.6f);
          Blocks.DARK_OAK_FENCE.setDefaultSlipperiness(0.6f);
          Blocks.ACACIA_FENCE.setDefaultSlipperiness(0.6f);
          Blocks.PUMPKIN.setDefaultSlipperiness(0.6f);
          Blocks.NETHERRACK.setDefaultSlipperiness(0.6f);
          Blocks.SOUL_SAND.setDefaultSlipperiness(0.6f);
          Blocks.GLOWSTONE.setDefaultSlipperiness(0.6f);
          Blocks.LIT_PUMPKIN.setDefaultSlipperiness(0.6f);
          Blocks.CAKE.setDefaultSlipperiness(0.6f);
          Blocks.TRAPDOOR.setDefaultSlipperiness(0.6f);
          Blocks.MONSTER_EGG.setDefaultSlipperiness(0.6f);
          Blocks.STONEBRICK.setDefaultSlipperiness(0.6f);
          Blocks.BROWN_MUSHROOM_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.RED_MUSHROOM_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.IRON_BARS.setDefaultSlipperiness(0.6f);
          Blocks.GLASS_PANE.setDefaultSlipperiness(0.6f);
          Blocks.MELON_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.BRICK_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.STONE_BRICK_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.MYCELIUM.setDefaultSlipperiness(0.6f);
          Blocks.NETHER_BRICK.setDefaultSlipperiness(0.6f);
          Blocks.NETHER_BRICK_FENCE.setDefaultSlipperiness(0.6f);
          Blocks.NETHER_BRICK_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.ENCHANTING_TABLE.setDefaultSlipperiness(0.6f);
          Blocks.BREWING_STAND.setDefaultSlipperiness(0.6f);
          Blocks.CAULDRON.setDefaultSlipperiness(0.6f);
          Blocks.END_PORTAL_FRAME.setDefaultSlipperiness(0.6f);
          Blocks.END_STONE.setDefaultSlipperiness(0.6f);
          Blocks.DRAGON_EGG.setDefaultSlipperiness(0.6f);
          Blocks.REDSTONE_LAMP.setDefaultSlipperiness(0.6f);
          Blocks.LIT_REDSTONE_LAMP.setDefaultSlipperiness(0.6f);
          Blocks.DOUBLE_WOODEN_SLAB.setDefaultSlipperiness(0.6f);
          Blocks.WOODEN_SLAB.setDefaultSlipperiness(0.6f);
          Blocks.SANDSTONE_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.EMERALD_ORE.setDefaultSlipperiness(0.6f);
          Blocks.ENDER_CHEST.setDefaultSlipperiness(0.6f);
          Blocks.EMERALD_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.SPRUCE_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.BIRCH_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.JUNGLE_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.COMMAND_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.BEACON.setDefaultSlipperiness(0.6f);
          Blocks.COBBLESTONE_WALL.setDefaultSlipperiness(0.6f);
          Blocks.FLOWER_POT.setDefaultSlipperiness(0.6f);
          Blocks.SKULL.setDefaultSlipperiness(0.6f);
          Blocks.ANVIL.setDefaultSlipperiness(0.6f);
          Blocks.TRAPPED_CHEST.setDefaultSlipperiness(0.6f);
          Blocks.DAYLIGHT_DETECTOR.setDefaultSlipperiness(0.6f);
          Blocks.DAYLIGHT_DETECTOR_INVERTED.setDefaultSlipperiness(0.6f);
          Blocks.REDSTONE_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.QUARTZ_ORE.setDefaultSlipperiness(0.6f);
          Blocks.HOPPER.setDefaultSlipperiness(0.6f);
          Blocks.QUARTZ_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.QUARTZ_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.DROPPER.setDefaultSlipperiness(0.6f);
          Blocks.STAINED_HARDENED_CLAY.setDefaultSlipperiness(0.6f);
          Blocks.BARRIER.setDefaultSlipperiness(0.6f);
          Blocks.IRON_TRAPDOOR.setDefaultSlipperiness(0.6f);
          Blocks.HAY_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.CARPET.setDefaultSlipperiness(0.6f);
          Blocks.HARDENED_CLAY.setDefaultSlipperiness(0.6f);
          Blocks.COAL_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.PACKED_ICE.setDefaultSlipperiness(0.6f);
          Blocks.ACACIA_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.DARK_OAK_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.SLIME_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.STAINED_GLASS.setDefaultSlipperiness(0.6f);
          Blocks.STAINED_GLASS_PANE.setDefaultSlipperiness(0.6f);
          Blocks.PRISMARINE.setDefaultSlipperiness(0.6f);
          Blocks.SEA_LANTERN.setDefaultSlipperiness(0.6f);
          Blocks.STANDING_BANNER.setDefaultSlipperiness(0.6f);
          Blocks.RED_SANDSTONE.setDefaultSlipperiness(0.6f);
          Blocks.RED_SANDSTONE_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.DOUBLE_STONE_SLAB2.setDefaultSlipperiness(0.6f);
          Blocks.STONE_SLAB2.setDefaultSlipperiness(0.6f);
          Blocks.END_ROD.setDefaultSlipperiness(0.6f);
          Blocks.PURPUR_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.PURPUR_PILLAR.setDefaultSlipperiness(0.6f);
          Blocks.PURPUR_STAIRS.setDefaultSlipperiness(0.6f);
          Blocks.PURPUR_DOUBLE_SLAB.setDefaultSlipperiness(0.6f);
          Blocks.PURPUR_SLAB.setDefaultSlipperiness(0.6f);
          Blocks.END_BRICKS.setDefaultSlipperiness(0.6f);
          Blocks.GRASS_PATH.setDefaultSlipperiness(0.6f);
          Blocks.REPEATING_COMMAND_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.CHAIN_COMMAND_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.FROSTED_ICE.setDefaultSlipperiness(0.6f);
          Blocks.MAGMA.setDefaultSlipperiness(0.6f);
          Blocks.NETHER_WART_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks. RED_NETHER_BRICK.setDefaultSlipperiness(0.6f);
          Blocks.BONE_BLOCK.setDefaultSlipperiness(0.6f);
          Blocks.OBSERVER.setDefaultSlipperiness(0.6f);
          Blocks.WHITE_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.ORANGE_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.MAGENTA_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.LIGHT_BLUE_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.YELLOW_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.LIME_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.PINK_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.GRAY_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.SILVER_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.CYAN_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.PURPLE_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.BLUE_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.BROWN_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.GREEN_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.RED_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.BLACK_SHULKER_BOX.setDefaultSlipperiness(0.6f);
          Blocks.WHITE_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.ORANGE_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.MAGENTA_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.YELLOW_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.LIME_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.PINK_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.GRAY_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.SILVER_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.CYAN_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.PURPLE_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.BLUE_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.BROWN_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.GREEN_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.RED_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.BLACK_GLAZED_TERRACOTTA.setDefaultSlipperiness(0.6f);
          Blocks.CONCRETE.setDefaultSlipperiness(0.6f);
          Blocks.CONCRETE_POWDER.setDefaultSlipperiness(0.6f);
		
	}
	
    @EventHandler
    private Listener<EntityJoinWorldEvent> OnWorldEvent = new Listener<>(p_Event ->
    {
            toggle();
    });
			
}	

