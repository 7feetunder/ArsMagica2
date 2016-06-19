package am2.buffs;

import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import am2.defs.PotionEffectsDefs;

public class BuffEffectFrostSlowed extends BuffEffect{

	private static final UUID frostSlow = UUID.fromString("03B0A79B-9569-43AE-BFE3-820D993D4A64");
	private static final AttributeModifier frostSlow_Diminished = (new AttributeModifier(frostSlow, "Frost Slow (Diminished)", -0.2, 2));
	private static final AttributeModifier frostSlow_Normal = (new AttributeModifier(frostSlow, "Frost Slow (Normal)", -0.5, 2));
	private static final AttributeModifier frostSlow_Augmented = (new AttributeModifier(frostSlow, "Frost Slow (Augmented)", -0.8, 2));

	public BuffEffectFrostSlowed(int duration, int amplifier){
		super(PotionEffectsDefs.frostSlow, duration, amplifier);
	}

	@Override
	public boolean shouldNotify(){
		return false;
	}

	@Override
	protected String spellBuffName(){
		return "Frost Slow";
	}

	@Override
	public void applyEffect(EntityLivingBase entityliving){
		IAttributeInstance attributeinstance = entityliving.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);

		if (attributeinstance.getModifier(frostSlow) != null){
			attributeinstance.removeModifier(frostSlow_Diminished);
			attributeinstance.removeModifier(frostSlow_Normal);
			attributeinstance.removeModifier(frostSlow_Augmented);
		}

		switch (this.getAmplifier()){
		case 0:
			attributeinstance.applyModifier(frostSlow_Diminished);
			break;
		case 1:
			attributeinstance.applyModifier(frostSlow_Normal);
			break;
		case 2:
			attributeinstance.applyModifier(frostSlow_Augmented);
			break;
		}
	}

	@Override
	public void stopEffect(EntityLivingBase entityliving){
		IAttributeInstance attributeinstance = entityliving.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);

		if (attributeinstance.getModifier(frostSlow) != null){
			attributeinstance.removeModifier(frostSlow_Diminished);
			attributeinstance.removeModifier(frostSlow_Normal);
			attributeinstance.removeModifier(frostSlow_Augmented);
		}
	}

	@Override
	public void performEffect(EntityLivingBase entityliving){
	}
}
