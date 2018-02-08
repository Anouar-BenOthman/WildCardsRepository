/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.entite.Promotion;
import java.util.List;

/**
 *
 * @author Aziz
 */
public interface IPromotionService {
    public void createPromotion(Promotion p);
    public List <Promotion> getAllPromotion();
    public Promotion getPromotionbyId (int id);
    public boolean deletePromotion(int id);
    public boolean deletePromotion (Promotion p);
    public boolean updatePromotion (Promotion p);
    public boolean updatePromotion (int p);
    
}
