package br.com.servico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.servico.domain.Grupo;
import br.com.servico.domain.Mensagem;
import br.com.servico.util.HibernateUtil;

public class MensagemDAO extends GenericDAO<Mensagem>{
	
	public List<Mensagem> retornarMensagensDoGrupo(String nomeGrupo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Mensagem.class);
			consulta.createAlias("grupo", "s");
			consulta.add(Restrictions.or(Restrictions.ilike("s.nomeGrupo", 	nomeGrupo, MatchMode.ANYWHERE),
						 Restrictions.ilike("s.nomeGrupo", 	nomeGrupo, MatchMode.ANYWHERE)));
			
			List<Mensagem> mensagens = consulta.list();
			return mensagens;
		}catch (Exception e) {
			throw e;
		}finally {
			sessao.close();
		}
		
	}

}
