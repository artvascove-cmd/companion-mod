package com.companion.mod.entity;

public class CompanionBattery {
    private int batteryLevel = 100;
    private boolean hasUpgrade = false;

    public void setBatteryLevel(int level) {
        this.batteryLevel = Math.max(0, Math.min(100, level));
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public String getBatteryColorState() {
        if (batteryLevel == 0) return "BLACK (Low Battery - Functions Offline)";
        if (batteryLevel <= 15) return "RED (Low Battery)";
        if (batteryLevel <= 50) return "YELLOW";
        if (batteryLevel <= 80) return "GREEN";
        return "BLUE (Fully Charged)";
    }

    public void recharge() {
        int rechargeAmount = hasUpgrade ? 25 : 15;
        setBatteryLevel(batteryLevel + rechargeAmount);
    }
}