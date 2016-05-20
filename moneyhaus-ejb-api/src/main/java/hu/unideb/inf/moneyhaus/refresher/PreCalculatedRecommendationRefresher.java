/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.refresher;

/**
 * Retrieves currency exchange rates from a specific period and decides whether
 * it is recommended or not.
 */
public interface PreCalculatedRecommendationRefresher {

    /**
     * Recalculates the recommended currency rates.
     */
    public void refresh();

}
