package am2.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockLightDecay extends BlockAM {
	
	public BlockLightDecay() {
		super(Material.AIR);
		setTickRandomly(true);
	}
	
	@Override
	public int getLightValue(IBlockState state) {
		return 15;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
		return null;
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
		return new AxisAlignedBB(pos.getX() + 0.45F, pos.getY() + 0.45F, pos.getZ() + 0.45F, pos.getX() + 0.55F, pos.getY() + 0.55F, pos.getZ() + 0.55F);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		worldIn.setBlockToAir(pos);
	}
}
