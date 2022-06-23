package br.com.jhisolution.user.hunters.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A DadosPessoais.
 */
@Entity
@Table(name = "dados_pessoais")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DadosPessoais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nome", length = 20, nullable = false)
    private String nome;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sobre_nome", length = 50, nullable = false)
    private String sobreNome;

    @Size(min = 1, max = 50)
    @Column(name = "pai", length = 50)
    private String pai;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mae", length = 50, nullable = false)
    private String mae;

    @Size(min = 8, max = 20)
    @Column(name = "telefone", length = 20)
    private String telefone;

    @NotNull
    @Size(min = 8, max = 20)
    @Column(name = "celular", length = 20, nullable = false)
    private String celular;

    @Size(min = 8, max = 20)
    @Column(name = "whatsapp", length = 20)
    private String whatsapp;

    @NotNull
    @Size(min = 9, max = 50)
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private EstadoCivil estadoCivil;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Raca raca;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Religiao religiao;

    @OneToOne
    @JoinColumn(unique = true)
    private Foto foto;

    @OneToOne
    @JoinColumn(unique = true)
    private FotoAvatar fotoAvatar;

    @OneToOne
    @JoinColumn(unique = true)
    private FotoIcon fotoIcon;

    @OneToMany(mappedBy = "dadosPessoais")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "tipo", "dadosPessoais" }, allowSetters = true)
    private Set<Mensagem> mensagems = new HashSet<>();

    @OneToMany(mappedBy = "dadosPessoais")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "dadosPessoais" }, allowSetters = true)
    private Set<Aviso> avisos = new HashSet<>();

    @OneToMany(mappedBy = "dadosPessoais")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "fotos", "dadosPessoais" }, allowSetters = true)
    private Set<Documento> documentos = new HashSet<>();

    @OneToMany(mappedBy = "dadosPessoais")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "dadosPessoais" }, allowSetters = true)
    private Set<Endereco> enderecos = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "dadosPessoais" }, allowSetters = true)
    private User1 user;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public DadosPessoais id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public DadosPessoais nome(String nome) {
        this.setNome(nome);
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return this.sobreNome;
    }

    public DadosPessoais sobreNome(String sobreNome) {
        this.setSobreNome(sobreNome);
        return this;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getPai() {
        return this.pai;
    }

    public DadosPessoais pai(String pai) {
        this.setPai(pai);
        return this;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return this.mae;
    }

    public DadosPessoais mae(String mae) {
        this.setMae(mae);
        return this;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public DadosPessoais telefone(String telefone) {
        this.setTelefone(telefone);
        return this;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return this.celular;
    }

    public DadosPessoais celular(String celular) {
        this.setCelular(celular);
        return this;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getWhatsapp() {
        return this.whatsapp;
    }

    public DadosPessoais whatsapp(String whatsapp) {
        this.setWhatsapp(whatsapp);
        return this;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return this.email;
    }

    public DadosPessoais email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EstadoCivil getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public DadosPessoais estadoCivil(EstadoCivil estadoCivil) {
        this.setEstadoCivil(estadoCivil);
        return this;
    }

    public Raca getRaca() {
        return this.raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public DadosPessoais raca(Raca raca) {
        this.setRaca(raca);
        return this;
    }

    public Religiao getReligiao() {
        return this.religiao;
    }

    public void setReligiao(Religiao religiao) {
        this.religiao = religiao;
    }

    public DadosPessoais religiao(Religiao religiao) {
        this.setReligiao(religiao);
        return this;
    }

    public Foto getFoto() {
        return this.foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public DadosPessoais foto(Foto foto) {
        this.setFoto(foto);
        return this;
    }

    public FotoAvatar getFotoAvatar() {
        return this.fotoAvatar;
    }

    public void setFotoAvatar(FotoAvatar fotoAvatar) {
        this.fotoAvatar = fotoAvatar;
    }

    public DadosPessoais fotoAvatar(FotoAvatar fotoAvatar) {
        this.setFotoAvatar(fotoAvatar);
        return this;
    }

    public FotoIcon getFotoIcon() {
        return this.fotoIcon;
    }

    public void setFotoIcon(FotoIcon fotoIcon) {
        this.fotoIcon = fotoIcon;
    }

    public DadosPessoais fotoIcon(FotoIcon fotoIcon) {
        this.setFotoIcon(fotoIcon);
        return this;
    }

    public Set<Mensagem> getMensagems() {
        return this.mensagems;
    }

    public void setMensagems(Set<Mensagem> mensagems) {
        if (this.mensagems != null) {
            this.mensagems.forEach(i -> i.setDadosPessoais(null));
        }
        if (mensagems != null) {
            mensagems.forEach(i -> i.setDadosPessoais(this));
        }
        this.mensagems = mensagems;
    }

    public DadosPessoais mensagems(Set<Mensagem> mensagems) {
        this.setMensagems(mensagems);
        return this;
    }

    public DadosPessoais addMensagem(Mensagem mensagem) {
        this.mensagems.add(mensagem);
        mensagem.setDadosPessoais(this);
        return this;
    }

    public DadosPessoais removeMensagem(Mensagem mensagem) {
        this.mensagems.remove(mensagem);
        mensagem.setDadosPessoais(null);
        return this;
    }

    public Set<Aviso> getAvisos() {
        return this.avisos;
    }

    public void setAvisos(Set<Aviso> avisos) {
        if (this.avisos != null) {
            this.avisos.forEach(i -> i.setDadosPessoais(null));
        }
        if (avisos != null) {
            avisos.forEach(i -> i.setDadosPessoais(this));
        }
        this.avisos = avisos;
    }

    public DadosPessoais avisos(Set<Aviso> avisos) {
        this.setAvisos(avisos);
        return this;
    }

    public DadosPessoais addAviso(Aviso aviso) {
        this.avisos.add(aviso);
        aviso.setDadosPessoais(this);
        return this;
    }

    public DadosPessoais removeAviso(Aviso aviso) {
        this.avisos.remove(aviso);
        aviso.setDadosPessoais(null);
        return this;
    }

    public Set<Documento> getDocumentos() {
        return this.documentos;
    }

    public void setDocumentos(Set<Documento> documentos) {
        if (this.documentos != null) {
            this.documentos.forEach(i -> i.setDadosPessoais(null));
        }
        if (documentos != null) {
            documentos.forEach(i -> i.setDadosPessoais(this));
        }
        this.documentos = documentos;
    }

    public DadosPessoais documentos(Set<Documento> documentos) {
        this.setDocumentos(documentos);
        return this;
    }

    public DadosPessoais addDocumento(Documento documento) {
        this.documentos.add(documento);
        documento.setDadosPessoais(this);
        return this;
    }

    public DadosPessoais removeDocumento(Documento documento) {
        this.documentos.remove(documento);
        documento.setDadosPessoais(null);
        return this;
    }

    public Set<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        if (this.enderecos != null) {
            this.enderecos.forEach(i -> i.setDadosPessoais(null));
        }
        if (enderecos != null) {
            enderecos.forEach(i -> i.setDadosPessoais(this));
        }
        this.enderecos = enderecos;
    }

    public DadosPessoais enderecos(Set<Endereco> enderecos) {
        this.setEnderecos(enderecos);
        return this;
    }

    public DadosPessoais addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
        endereco.setDadosPessoais(this);
        return this;
    }

    public DadosPessoais removeEndereco(Endereco endereco) {
        this.enderecos.remove(endereco);
        endereco.setDadosPessoais(null);
        return this;
    }

    public User1 getUser() {
        return this.user;
    }

    public void setUser(User1 user1) {
        this.user = user1;
    }

    public DadosPessoais user(User1 user1) {
        this.setUser(user1);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DadosPessoais)) {
            return false;
        }
        return id != null && id.equals(((DadosPessoais) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DadosPessoais{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", sobreNome='" + getSobreNome() + "'" +
            ", pai='" + getPai() + "'" +
            ", mae='" + getMae() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", celular='" + getCelular() + "'" +
            ", whatsapp='" + getWhatsapp() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
}