package hu.unideb.inf.moneyhaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.unideb.inf.moneyhaus.entities.CurrencyRate;

public interface CurrencyRateDao extends JpaRepository<CurrencyRate, Long> {

}
