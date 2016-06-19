package am2.spell;

import java.util.EnumSet;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public interface IModifier extends ISpellPart{
	/**
	 * Returns a list of the aspects of a spell that this modifier can change.
	 *
	 * @return
	 */
	public EnumSet<SpellModifiers> getAspectsModified();

	/**
	 * Returns the modified value for the specified type.
	 *
	 * @param type     The type of value we are modifying
	 * @param caster   The caster
	 * @param target   The target (can be the same as the caster)
	 * @param world    The world in which the spell is being cast.
	 * @param metadata Any metadata written to the spell for this modifier (obtained from getModifierMetadata)
	 * @return A factor to multiply the default value by (or add, depending on the component's programming)
	 */
	public float getModifier(SpellModifiers type, EntityLivingBase caster, Entity target, World world, NBTTagCompound nbt);

	/**
	 * Gets the amount that adding this modifier to the spell alters the mana cost.
	 *
	 * @param spellStack The itemstack comprising the spell (in case you want to base it on other modifiers added)
	 * @param stage      The stage in which this modifier has been added (if the modifier is added to multiple stages, this will be called multiple times, once per stage)
	 * @param quantity   The quantity of this multiplier in the specified stage.
	 */
	public float getManaCostMultiplier(ItemStack spellStack, int stage, int quantity);
}
