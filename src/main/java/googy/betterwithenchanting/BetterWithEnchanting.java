package googy.betterwithenchanting;

import googy.betterwithenchanting.block.BlockEnchantmentTable;
import googy.betterwithenchanting.block.entity.TileEntityEnchantmentTable;
import googy.betterwithenchanting.mixin.PacketMixin;
import googy.betterwithenchanting.network.packet.PacketEnchantItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.sound.block.BlockSound;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.NetworkHelper;


public class BetterWithEnchanting implements ModInitializer {
    public static final String MOD_ID = "betterwithenchanting";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

	Block enchantmentTable = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
		.setHardness(5)
		.setResistance(1200)
		.setLuminance(7)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.setBottomTexture("enchantment_table/bottom.png")
		.setSideTextures("enchantment_table/side.png")
		.setTopTexture("enchantment_table/top.png")
		.build(new BlockEnchantmentTable("enchantmenttable", 14150));

	static {
		EntityHelper.createTileEntity(TileEntityEnchantmentTable.class, "EnchantmentTable");
		//NetworkHelper.register(PacketEnchantItem.class, true, false);
		PacketMixin.callAddIdClassMapping(301, false, true, PacketEnchantItem.class);
	}

    @Override
    public void onInitialize() {
		LOG.info("BetterWithEnchanting initialized!");

    }
}