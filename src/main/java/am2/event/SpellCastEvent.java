package am2.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.Event;

public class SpellCastEvent extends Event {
	
	public ItemStack spell;
	public int manaCost;
	public EntityLivingBase entityLiving;
	
	public SpellCastEvent(EntityLivingBase caster, ItemStack spell, int manaCost) {
		this.spell = spell;
		this.manaCost = manaCost;
		this.entityLiving = caster;
	}
	
	public static class Pre extends SpellCastEvent {

		public Pre(EntityLivingBase caster, ItemStack spell, int manaCost) {
			super(caster, spell, manaCost);
		}
		
	}
	
	public static class Post extends SpellCastEvent {

		public Post(EntityLivingBase caster, ItemStack spell, int manaCost) {
			super(caster, spell, manaCost);
		}
		
	}

}
