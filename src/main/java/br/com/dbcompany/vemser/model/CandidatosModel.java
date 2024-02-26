package br.com.dbcompany.vemser.model;

import java.util.List;

public class CandidatosModel {
    private int idCandidato;
    private String nome;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String rg;
    private String cpf;
    private String estado;
    private String cidade;
    private Double nota;
    private String pcd;
    private String observacoes;
    private Double notaEntrevistaComportamental;
    private Double notaEntrevistaTecnica;
    private String ativo;
    private String parecerComportamental;
    private String parecerTecnico;
    private Double media;
    private List<String> linguagens;
    private Edicao edicao;
    private Formulario formulario;

    // getters e setters omitidos

    public static class Edicao {
        private int idEdicao;
        private String nome;

        public int getIdEdicao() {
            return idEdicao;
        }

        public void setIdEdicao(int idEdicao) {
            this.idEdicao = idEdicao;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        @Override
        public String toString() {
            return "Edicao{" +
                    "idEdicao=" + idEdicao +
                    ", nome='" + nome + '\'' +
                    '}';
        }
    }

    public static class Formulario {
        private int idFormulario;
        private String matriculado;
        private String curso;
        private String turno;
        private String instituicao;
        private String github;
        private String linkedin;
        private String desafios;
        private String problema;
        private String reconhecimento;
        private String altruismo;
        private String resposta;
        private int curriculo;
        private String lgpd;
        private String prova;
        private String ingles;
        private String espanhol;
        private String neurodiversidade;
        private String etnia;
        private String efetivacao;
        private String genero;
        private String orientacao;
        private String disponibilidade;
        private List<Trilha> trilhas;
        private String imagemConfigPc;
        private String importancia;

        // getters e setters omitidos

        public static class Trilha {
            private String nome;
            private int idTrilha;

            // getters e setters omitidos

            public String getNome() {
                return nome;
            }

            public void setNome(String nome) {
                this.nome = nome;
            }

            public int getIdTrilha() {
                return idTrilha;
            }

            public void setIdTrilha(int idTrilha) {
                this.idTrilha = idTrilha;
            }
        }

        public int getIdFormulario() {
            return idFormulario;
        }

        public void setIdFormulario(int idFormulario) {
            this.idFormulario = idFormulario;
        }

        public String getMatriculado() {
            return matriculado;
        }

        public void setMatriculado(String matriculado) {
            this.matriculado = matriculado;
        }

        public String getCurso() {
            return curso;
        }

        public void setCurso(String curso) {
            this.curso = curso;
        }

        public String getTurno() {
            return turno;
        }

        public void setTurno(String turno) {
            this.turno = turno;
        }

        public String getInstituicao() {
            return instituicao;
        }

        public void setInstituicao(String instituicao) {
            this.instituicao = instituicao;
        }

        public String getGithub() {
            return github;
        }

        public void setGithub(String github) {
            this.github = github;
        }

        public String getLinkedin() {
            return linkedin;
        }

        public void setLinkedin(String linkedin) {
            this.linkedin = linkedin;
        }

        public String getDesafios() {
            return desafios;
        }

        public void setDesafios(String desafios) {
            this.desafios = desafios;
        }

        public String getProblema() {
            return problema;
        }

        public void setProblema(String problema) {
            this.problema = problema;
        }

        public String getReconhecimento() {
            return reconhecimento;
        }

        public void setReconhecimento(String reconhecimento) {
            this.reconhecimento = reconhecimento;
        }

        public String getAltruismo() {
            return altruismo;
        }

        public void setAltruismo(String altruismo) {
            this.altruismo = altruismo;
        }

        public String getResposta() {
            return resposta;
        }

        public void setResposta(String resposta) {
            this.resposta = resposta;
        }

        public int getCurriculo() {
            return curriculo;
        }

        public void setCurriculo(int curriculo) {
            this.curriculo = curriculo;
        }

        public String getLgpd() {
            return lgpd;
        }

        public void setLgpd(String lgpd) {
            this.lgpd = lgpd;
        }

        public String getProva() {
            return prova;
        }

        public void setProva(String prova) {
            this.prova = prova;
        }

        public String getIngles() {
            return ingles;
        }

        public void setIngles(String ingles) {
            this.ingles = ingles;
        }

        public String getEspanhol() {
            return espanhol;
        }

        public void setEspanhol(String espanhol) {
            this.espanhol = espanhol;
        }

        public String getNeurodiversidade() {
            return neurodiversidade;
        }

        public void setNeurodiversidade(String neurodiversidade) {
            this.neurodiversidade = neurodiversidade;
        }

        public String getEtnia() {
            return etnia;
        }

        public void setEtnia(String etnia) {
            this.etnia = etnia;
        }

        public String getEfetivacao() {
            return efetivacao;
        }

        public void setEfetivacao(String efetivacao) {
            this.efetivacao = efetivacao;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getOrientacao() {
            return orientacao;
        }

        public void setOrientacao(String orientacao) {
            this.orientacao = orientacao;
        }

        public String getDisponibilidade() {
            return disponibilidade;
        }

        public void setDisponibilidade(String disponibilidade) {
            this.disponibilidade = disponibilidade;
        }

        public List<Trilha> getTrilhas() {
            return trilhas;
        }

        public void setTrilhas(List<Trilha> trilhas) {
            this.trilhas = trilhas;
        }

        public String getImagemConfigPc() {
            return imagemConfigPc;
        }

        public void setImagemConfigPc(String imagemConfigPc) {
            this.imagemConfigPc = imagemConfigPc;
        }

        public String getImportancia() {
            return importancia;
        }

        public void setImportancia(String importancia) {
            this.importancia = importancia;
        }
    }
    // region Getters and Setters
    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getPcd() {
        return pcd;
    }

    public void setPcd(String pcd) {
        this.pcd = pcd;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Double getNotaEntrevistaComportamental() {
        return notaEntrevistaComportamental;
    }

    public void setNotaEntrevistaComportamental(Double notaEntrevistaComportamental) {
        this.notaEntrevistaComportamental = notaEntrevistaComportamental;
    }

    public Double getNotaEntrevistaTecnica() {
        return notaEntrevistaTecnica;
    }

    public void setNotaEntrevistaTecnica(Double notaEntrevistaTecnica) {
        this.notaEntrevistaTecnica = notaEntrevistaTecnica;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getParecerComportamental() {
        return parecerComportamental;
    }

    public void setParecerComportamental(String parecerComportamental) {
        this.parecerComportamental = parecerComportamental;
    }

    public String getParecerTecnico() {
        return parecerTecnico;
    }

    public void setParecerTecnico(String parecerTecnico) {
        this.parecerTecnico = parecerTecnico;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public List<String> getLinguagens() {
        return linguagens;
    }

    public void setLinguagens(List<String> linguagens) {
        this.linguagens = linguagens;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }
    // endregion

    @Override
    public String toString() {
        return "CandidatosModel{" +
                "idCandidato=" + idCandidato +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", edicao=" + edicao +
                '}';
    }
}
