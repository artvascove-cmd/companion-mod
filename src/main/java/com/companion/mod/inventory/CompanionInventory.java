package com.companion.mod.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class CompanionInventory {
    // Slot 0: Iron input (Raw Iron or Iron Ingot)
    // Slot 1: Redstone input (Redstone Dust)
    private final ItemStack[] slots = new ItemStack[]{ItemStack.EMPTY, ItemStack.EMPTY};
    private int batteryLevel = 100;
    private boolean hasUpgrade = false;

    public void setSlot(int slot, ItemStack stack) {
        if (slot >= 0 && slot < slots.length) {
            slots[slot] = stack;
        }
    }

    public void processRecharge() {
        boolean hasIron = !slots[0].isEmpty() && (slots[0].isOf(Items.RAW_IRON) || slots[0].isOf(Items.IRON_INGOT));
        boolean hasRedstone = !slots[1].isEmpty() && slots[1].isOf(Items.REDSTONE);

        if (hasIron && hasRedstone) {
            slots[0].decrement(1);
            slots[1].decrement(1);
            
            int rechargeAmount = hasUpgrade ? 25 : 15;
            batteryLevel = Math.min(100, batteryLevel + rechargeAmount);
        }
    }
}