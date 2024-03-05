package br.com.dbcompany.vemser.dataFactory;

import br.com.dbcompany.vemser.model.LoginModel;
import br.com.dbcompany.vemser.utils.DataFakerGenerator;
import org.apache.commons.lang3.StringUtils;

public class LoginData {
    public static LoginModel loginDadosValidos(String email, String senha){
        LoginModel loginDTO = new LoginModel();
        loginDTO.setLogin(email);
        loginDTO.setSenha(senha);
        return loginDTO;
    }
    public static LoginModel loginEmailInvalido(){
        LoginModel loginDTO = new LoginModel();
        loginDTO.setLogin(DataFakerGenerator.nomeFaker() + "@");
        loginDTO.setSenha(DataFakerGenerator.senhaFaker());
        return loginDTO;
    }
    public static LoginModel loginSenhaInvalida(){
        LoginModel loginDTO = new LoginModel();
        loginDTO.setLogin("admin.teste");
        loginDTO.setSenha(DataFakerGenerator.senhaFaker());
        return loginDTO;
    }
    public static LoginModel loginEmailEmBranco(){
        LoginModel loginDTO = new LoginModel();
        loginDTO.setLogin(StringUtils.EMPTY);
        loginDTO.setSenha(DataFakerGenerator.senhaFaker());
        return loginDTO;
    }
    public static LoginModel loginSenhaEmBranco(){
        LoginModel loginDTO = new LoginModel();
        loginDTO.setLogin("admin.teste");
        loginDTO.setSenha(StringUtils.EMPTY);
        return loginDTO;
    }
}
