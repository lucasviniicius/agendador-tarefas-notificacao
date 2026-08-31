# 📋 Agendador de Tarefas com Notificação por Email

Um serviço de notificação em **Java** com **Spring Boot** que envia emails automáticos para alertar usuários sobre suas tarefas agendadas.

## 🎯 Funcionalidades

- ✉️ Envio de emails automáticos de notificação de tarefas
- 📧 Suporte a templates HTML com Thymeleaf
- 🔒 Autenticação segura com Gmail SMTP
- 📝 API REST para agendamento de notificações
- 🛡️ Tratamento robusto de exceções

## 🏗️ Estrutura do Projeto

```
agendador-tarefas-notificacao/
├── src/
│   ├── main/
│   │   ├── java/com/notificacao/
│   │   │   ├── NotificacaoApplication.java (Classe principal)
│   │   │   ├── business/
│   │   │   │   ├── EmailService.java (Lógica de envio de email)
│   │   │   │   └── dto/
│   │   │   │       └── TarefaDTO.java (DTO da tarefa)
│   │   │   ├── controller/
│   │   │   │   └── EmailController.java (Endpoints REST)
│   │   │   └── infrastructure/
│   │   │       ├── enums/
│   │   │       │   └── StatusNotificacaoEnum.java
│   │   │       └── exceptions/
│   │   │           └── EmailException.java (Exceção customizada)
│   │   └── resources/
│   │       ├── application.yml (Configurações)
│   │       └── templates/
│   │           └── notificacao.html (Template do email)
│   └── test/
│       └── java/com/notificacao/
│           └── NotificacaoApplicationTests.java
├── build.gradle (Dependências e build)
├── settings.gradle
└── gradlew / gradlew.bat

```

## 🚀 Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|-----------|--------|-----------|
| **Java** | 17 | Linguagem principal |
| **Spring Boot** | 4.1.1 | Framework web |
| **Spring Mail** | - | Envio de emails |
| **Thymeleaf** | - | Template engine para emails HTML |
| **Lombok** | - | Redução de boilerplate |
| **Gradle** | - | Gerenciador de dependências |

## 📦 Dependências Principais

```gradle
- org.springframework.boot:spring-boot-starter-mail
- org.springframework.boot:spring-boot-starter-thymeleaf
- org.springframework.boot:spring-boot-starter-webmvc
- org.projectlombok:lombok
```

## ⚙️ Configuração

### Pré-requisitos

- Java 17+
- Gradle instalado (ou use o `gradlew` incluído)
- Conta Gmail com [senha de app configurada](https://support.google.com/accounts/answer/185833)

### Variáveis de Ambiente

Configure o arquivo `src/main/resources/application.yml`:

```yaml
spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: seu-email@gmail.com          # Seu email Gmail
    password: sua-senha-de-app              # Senha de app do Gmail
    protocol: smtp
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
          connectiontimeout: 5000
          timeout: 3000
          writetimeout: 5000

  thymeleaf:
    enable: true

envio:
  email:
    remetente: seu-email@gmail.com          # Email remetente
    nomeRemetente: 'Javanauta'             # Nome exibido

server:
  port: 8082                               # Porta da aplicação
```

## 🔌 API REST

### Enviar Notificação de Tarefa

**Endpoint:** `POST /email`

**Request Body:**
```json
{
  "nome": "Finalizar Projeto",
  "descricao": "Completar o desenvolvimento do módulo de notificações",
  "dataEvento": "2024-09-15",
  "emailUsuario": "usuario@example.com"
}
```

**Response:**
```
200 OK
```

**Exemplo com cURL:**
```bash
curl -X POST http://localhost:8082/email \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Reunião Importante",
    "descricao": "Reunião com a equipe de desenvolvimento",
    "dataEvento": "2024-09-20",
    "emailUsuario": "seu-email@gmail.com"
  }'
```

## 🚀 Como Executar

### 1. Clonar o Repositório
```bash
git clone https://github.com/lucasviniicius/agendador-tarefas-notificacao.git
cd agendador-tarefas-notificacao
```

### 2. Configurar Credenciais
Edite `src/main/resources/application.yml` com suas credenciais Gmail

### 3. Executar a Aplicação

**Com Gradle:**
```bash
./gradlew bootRun
```

**Ou compilar e executar:**
```bash
./gradlew build
java -jar build/libs/agendador-tarefas-notificacao-0.0.1-SNAPSHOT.jar
```

### 4. Verificar se está rodando
A aplicação estará disponível em: `http://localhost:8082`

## 📧 Template de Email

O template HTML está em `src/main/resources/templates/notificacao.html` e utiliza Thymeleaf para renderizar as variáveis:

- `${nome}` - Nome da tarefa
- `${descricao}` - Descrição da tarefa
- `${dataEvento}` - Data do evento

## 🧪 Testes

Execute os testes com:
```bash
./gradlew test
```

## 🛠️ Tratamento de Erros

A aplicação lança `EmailException` quando há erro no envio de emails. Você pode capturar e tratar conforme necessário:

```java
try {
    emailService.enviaEmail(tarefaDTO);
} catch (EmailException e) {
    // Tratar erro
    log.error("Erro ao enviar email: ", e);
}
```

## 📊 Linguagens Utilizadas

- **Java**: 76.5%
- **HTML**: 23.5%

## 📝 Estrutura de Commits

A aplicação utiliza CI/CD com GitHub Actions. Veja o arquivo `.github/workflows/gradle.yml` para mais detalhes.

## 🤝 Contribuindo

Sinta-se livre para:
1. Fork o projeto
2. Criar uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abrir um Pull Request

## 📄 Licença

Este projeto é de código aberto. Verifique a licença no repositório.

## 📞 Contato

- **Autor**: lucasviniicius
- **GitHub**: [lucasviniicius](https://github.com/lucasviniicius)
- **Repositório**: [agendador-tarefas-notificacao](https://github.com/lucasviniicius/agendador-tarefas-notificacao)

---

**⭐ Se este projeto foi útil, considere dar uma estrela!**
