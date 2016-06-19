package am2.spell.component;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

import am2.affinity.Affinity;
import am2.buffs.BuffEffectRegeneration;
import am2.defs.ItemDefs;
import am2.defs.PotionEffectsDefs;
import am2.defs.SkillDefs;
import am2.extensions.EntityExtension;
import am2.spell.IComponent;
import am2.spell.SpellModifiers;
import am2.utils.SpellUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Regeneration implements IComponent{

	@Override
	public boolean applyEffectBlock(ItemStack stack, World world, BlockPos blockPos, EnumFacing blockFace, double impactX, double impactY, double impactZ, EntityLivingBase caster){
		return false;
	}

	@Override
	public boolean applyEffectEntity(ItemStack stack, World world, EntityLivingBase caster, Entity target){
		if (target instanceof EntityLivingBase){
			if (EntityExtension.For((EntityLivingBase)target).canHeal()){
				int duration = SpellUtils.getModifiedInt_Mul(PotionEffectsDefs.default_buff_duration, stack, caster, target, world, SpellModifiers.DURATION);
				//duration = SpellUtils.instance.modifyDurationBasedOnArmor(caster, duration);
				if (!world.isRemote)
					((EntityLivingBase)target).addPotionEffect(new BuffEffectRegeneration(duration, SpellUtils.countModifiers(SpellModifiers.BUFF_POWER, stack)));
				EntityExtension.For((EntityLivingBase)target).setHealCooldown(60);
				return true;
			}
		}
		return false;
	}

	@Override
	public float manaCost(EntityLivingBase caster){
		return 540;
	}
	
	@Override
	public ItemStack[] reagents(EntityLivingBase caster){
		return null;
	}

	@Override
	public void spawnParticles(World world, double x, double y, double z, EntityLivingBase caster, Entity target, Random rand, int colorModifier){
//		for (int i = 0; i < 25; ++i){
//			AMParticle particle = (AMParticle)AMCore.proxy.particleManager.spawn(world, "sparkle", x, y - 1, z);
//			if (particle != null){
//				particle.addRandomOffset(1, 1, 1);
//				particle.AddParticleController(new ParticleFloatUpward(particle, 0, 0.1f, 1, false));
//				particle.AddParticleController(new ParticleOrbitEntity(particle, target, 0.5f, 2, false).setIgnoreYCoordinate(true).SetTargetDistance(0.3f + rand.nextDouble() * 0.3));
//				particle.setMaxAge(20);
//				particle.setParticleScale(0.2f);
//				particle.setRGBColorF(0.1f, 1f, 0.8f);
//				if (colorModifier > -1){
//					particle.setRGBColorF(((colorModifier >> 16) & 0xFF) / 255.0f, ((colorModifier >> 8) & 0xFF) / 255.0f, (colorModifier & 0xFF) / 255.0f);
//				}
//			}
//		}
	}

	@Override
	public Set<Affinity> getAffinity(){
		return Sets.newHashSet(SkillDefs.LIFE, SkillDefs.NATURE);
	}


	@Override
	public Object[] getRecipe(){
		return new Object[]{
				new ItemStack(ItemDefs.rune, 1, EnumDyeColor.BLUE.getDyeDamage()),
				Items.GOLDEN_APPLE
		};
	}

	@Override
	public float getAffinityShift(Affinity affinity){
		return 0.05f;
	}

	@Override
	public void encodeBasicData(NBTTagCompound tag, Object[] recipe) {}
}
