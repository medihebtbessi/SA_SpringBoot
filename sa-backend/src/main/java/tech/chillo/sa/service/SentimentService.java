package tech.chillo.sa.service;

import org.springframework.stereotype.Service;
import tech.chillo.sa.entity.Client;
import tech.chillo.sa.entity.Sentiment;
import tech.chillo.sa.enums.TypeSentiment;
import tech.chillo.sa.repository.SentimentRepository;

import java.util.List;

@Service
public class SentimentService {

    private ClientService clientService;

    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void creer(Sentiment sentiment){
        Client client=this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);

       /*if (sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        }else {
            sentiment.setType(TypeSentiment.POSITIF);
        }*/
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher() {
        return this.sentimentRepository.findAll();
    }
    /*
    * public List<Sentiment> rechercher(@RequestParanTypeSentiment type) {
    * if(type==null){
    * return this.sentimentRepository.findAll();
    *
    * }else{
    *       return this.sentimentRepository.findByType(type);
    * }
    }
    * */

    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
