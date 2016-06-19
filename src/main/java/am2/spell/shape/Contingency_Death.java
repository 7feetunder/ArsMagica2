package am2.spell.shape;

import am2.defs.ItemDefs;
import am2.defs.SkillDefs;
import am2.extensions.EntityExtension;
import am2.items.ItemOre;
import am2.items.ItemSpellBase;
import am2.spell.ContingencyType;
import am2.spell.IShape;
import am2.spell.SpellCastResult;
import am2.utils.AffinityShiftUtils;
import am2.utils.SpellUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class Contingency_Death implements IShape{

	@Override
	public Object[] getRecipe(){
		return new Object[]{
				Items.CLOCK,
				AffinityShiftUtils.getEssenceForAffinity(SkillDefs.ENDER),
				Blocks.STONE,
				Blocks.STONE_SLAB,
				Blocks.STONE_SLAB,
				Blocks.STONE_SLAB,
				Items.BLAZE_POWDER,
				//TODO BlockDefs.tarmaRoot,
				new ItemStack(ItemDefs.itemOre, 1, ItemOre.META_ARCANEASH),
				//TODO String.format("E:%d", PowerTypes.DARK.ID()), 5000
		};
	}

	@Override
	public SpellCastResult beginStackStage(ItemSpellBase item, ItemStack stack, EntityLivingBase caster, EntityLivingBase target, World world, double x, double y, double z, EnumFacing side, boolean giveXP, int useCount){
		EntityExtension.For(target != null ? target : caster).setContingency(ContingencyType.DEATH, SpellUtils.popStackStage(stack));
		return SpellCastResult.SUCCESS;
	}

	@Override
	public boolean isChanneled(){
		return false;
	}

	@Override
	public float manaCostMultiplier(ItemStack spellStack){
		return 10;
	}

	@Override
	public boolean isTerminusShape(){
		return false;
	}

	@Override
	public boolean isPrincipumShape(){
		return true;
	}

//	@Override
//	public String getSoundForAffinity(Affinity affinity, ItemStack stack, World world){
//		return "arsmagica2:spell.contingency.contingency";
//	}

	@Override
	public void encodeBasicData(NBTTagCompound tag, Object[] recipe) {}
}