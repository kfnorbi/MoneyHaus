ALTER TABLE `moneyhaus`.`daily_average` 
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '' ;

insert into daily_average(currencyCode,date_of_average,value)
select base,date(date_of_refresh),avg(rate) from currency_rate group by date(date_of_refresh),base;

ALTER TABLE `moneyhaus`.`daily_average` 
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL COMMENT '' ;
