package me.christ9979.zipkindemo2.persistance;

import me.christ9979.zipkindemo2.domain.SecondDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondCallRepository extends JpaRepository<SecondDomain, Long> {

}
