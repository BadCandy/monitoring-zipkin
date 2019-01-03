package me.christ9979.zipkindemo1.persistance;

import me.christ9979.zipkindemo1.domain.FirstDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstCallRepository extends JpaRepository<FirstDomain, Long> {

}
