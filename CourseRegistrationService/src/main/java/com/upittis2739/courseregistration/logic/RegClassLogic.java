/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.logic;

import com.upittis2739.courseregistration.model.RegClass;

/**
 *
 * @author riand_000
 */
public class RegClassLogic {
    public RegClass getRegClassById(int Cls_ID) {
        return RegClassDBOperation.getRegClassById(Cls_ID);
    }
}
