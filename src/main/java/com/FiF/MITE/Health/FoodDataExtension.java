package com.FiF.MITE.Health;

public interface FoodDataExtension {

    /** 设置饱食度上限 */
    void mite_setMaxFoodLevel(int maxFood);

    /** 获取饱食度上限 */
    int mite_getMaxFoodLevel();
}
