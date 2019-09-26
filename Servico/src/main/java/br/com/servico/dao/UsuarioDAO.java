package br.com.servico.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.servico.domain.Login;
import br.com.servico.domain.Usuario;
import br.com.servico.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario>{
	
	public Usuario LogarUsuario(Login login) {
		Usuario usuario = new Usuario();
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			
			Criteria consulta = sessao.createCriteria(Usuario.class);
			
			consulta.add(Restrictions.eq("email", login.getEmail()));
			consulta.add(Restrictions.eq("senha", login.getSenha()));
			
			usuario = (Usuario) consulta.uniqueResult();
			
			return usuario;
			
		} catch (RuntimeException erro) {
			erro.printStackTrace();
		} finally {
			sessao.close();
		}
		return usuario;
	}
	
	/**
	 * @author Alexandre V. Garcia
	 * @param nome
	 * @return
	 * 
	 * Retorna uma lista de usuarios por nome.
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> listarPorNome(String nome) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);
			
			consulta.add(Restrictions.or(	Restrictions.ilike("nome", 		nome, MatchMode.ANYWHERE),
											Restrictions.ilike("sobreNome", nome, MatchMode.ANYWHERE)));
			
			List<Usuario> resultado = consulta.list();
			
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
}
