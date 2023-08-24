package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * @author awl
 * @date 2023/8/24 10:37
 */
public interface DishService {

    /**
     * 新增菜品和对应的口味
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);
}
