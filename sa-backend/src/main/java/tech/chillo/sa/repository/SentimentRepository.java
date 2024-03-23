package tech.chillo.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.chillo.sa.entity.Sentiment;
import tech.chillo.sa.enums.TypeSentiment;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment,Integer> {

        List<Sentiment> findByType(TypeSentiment type);

}
