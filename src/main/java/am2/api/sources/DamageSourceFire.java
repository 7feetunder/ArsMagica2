package am2.api.sources;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EntityDamageSource;

public class DamageSourceFire extends EntityDamageSource{
	public DamageSourceFire(EntityLivingBase source){
		super("am2.fire", source);
		this.setFireDamage();
		this.setDamageBypassesArmor();
	}
}
