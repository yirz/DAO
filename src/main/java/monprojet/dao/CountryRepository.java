package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value="SELECT sum(population)As pop "+"FROM City " +"INNER JOIN Country ON city.country_id=country.id "+ "WHERE country.id = :idCountry ",nativeQuery = true)
    public int calculPop(Integer idCountry);


    @Query(value ="SELECT Country.name as nom, sum(population) as pop "+"FROM City " +"INNER JOIN Country ON city.country_id=country.id "+ "GROUP BY nom",nativeQuery = true )
    public List<PopCountry> popParPays();
}