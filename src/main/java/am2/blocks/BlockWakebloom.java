package am2.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockWakebloom extends BlockAMFlower{

	public BlockWakebloom(){
		super();
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos){
		return EnumPlantType.Water;
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).getBlock().equals(Blocks.WATER);
	}
	
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state){
		return canPlaceBlockAt(worldIn, pos);
	}
}
