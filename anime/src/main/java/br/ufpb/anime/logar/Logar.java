package br.ufpb.anime.logar;
import br.ufpb.anime.model.Usuario;
import br.ufpb.anime.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Logar {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    
    public Logar(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public void carregarUsuario() {
    	Usuario usuario = new Usuario();
    	usuario.setUsername("Tiago");
    	usuario.setPassword(bCryptPasswordEncoder.encode("123"));
    	usuarioRepository.save(usuario);
    }

    
    public Usuario getUsuario(){
        System.out.println("Entrando");
        return usuarioRepository.findByUsername("tiago");
    }

}
