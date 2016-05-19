/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.refresher;

import hu.unideb.inf.moneyhaus.service.PreCalculatedRecommendationService;
import hu.unideb.inf.moneyhaus.vo.PreCalculatedRecommendation;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Nolbelt
 */
@Stateless(mappedName = "preCalculatedRecommendationRefresher")
@Remote(PreCalculatedRecommendationRefresher.class)
public class PreCalculatedRecommendationRefresherImpl implements PreCalculatedRecommendationRefresher{

    @EJB
    PreCalculatedRecommendationService preCalculatedRecommendationService;
    
    @Override
    public void refresh() {
        List<PreCalculatedRecommendation> result = preCalculatedRecommendationService.calculateRecommendations();
        preCalculatedRecommendationService.save(result);
    }
    
}
