//package me.fit.service;
//
//import java.util.List;
//
//import jakarta.inject.Inject;
//import jakarta.persistence.EntityManager;
//import jakarta.transaction.Transactional;
//import me.fit.model.rest.client.IpClient;
//
//public class ClientService {
//	
//	@Inject
//	private EntityManager em;
//
//	@Transactional
//	public void saveClient(IpClient client) {
//		
//		List<IpClient> savedClient = get();
//		
//		//client.removeAll(savedClient);
//		
//		for (IpClient client1 : savedClient) {
//			em.merge(client1);
//		}
//		em.merge(savedClient);
//		
//	}
//	
//	@Transactional
//	public List<IpClient>  get(){
//		return em.createNamedQuery(IpClient.GET, IpClient.class).getResultList();
//	}
//}
