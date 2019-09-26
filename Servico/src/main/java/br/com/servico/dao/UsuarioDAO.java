package br.com.servico.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
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
	
}
