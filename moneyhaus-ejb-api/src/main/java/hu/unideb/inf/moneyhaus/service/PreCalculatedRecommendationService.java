/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.vo.PreCalculatedRecommendation;
import java.util.List;

/**
 *
 * @author Nolbelt
 */
public interface PreCalculatedRecommendationService {
        
    public void save(PreCalculatedRecommendation preCalculatedRecommendation);
    
    public void save(List<PreCalculatedRecommendation> preCalculatedRecommendations);
    
    public List<PreCalculatedRecommendation> calculateRecommendations();
    
    public List<PreCalculatedRecommendation> getBiggestRecommendations();
    
}
