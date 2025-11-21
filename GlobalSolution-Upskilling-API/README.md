# Global Solution - Plataforma de Upskilling/Reskilling (API)

**Nomes e RMs**
- Carlos Eduardo dos Santos Ribeiro Filho - RM: 556785
- Felipe Cerboncini Cordeiro - RM: 554909
- Pedro Henrique Martins Alves dos Santos - RM: 558107

**Descrição curta da Solução:** A SkillSync VR é uma plataforma educacional B2B (Business-to-Business) projetada para enfrentar o desafio central da Global Solution: "O Futuro do Trabalho". A solução é um ambiente de treinamento imersivo que utiliza Realidade Virtual (VR) para requalificação (reskilling) e aprimoramento (upskilling) de funcionários em habilidades técnicas complexas e soft skills.

**Descrição:** API RESTful em Java + Spring Boot para uma plataforma de upskilling/reskilling focada no futuro do trabalho (2030+). Implementa CRUDs de `Usuários` e `Trilhas` com validação, tratamento centralizado de exceções e seeds iniciais.

**Versões**
- Java: 21
- Spring Boot: 3.2.6

**Como executar**
1. Tenha Java 21 e Maven instalados.
2. Na raiz do projeto, rode:
```bash
mvn clean package
mvn spring-boot:run
```
ou
```bash
./mvnw spring-boot:run
```

**Banco de dados**
- H2 em memória configurado (URL: `jdbc:h2:mem:upskillingdb`).
- Console H2: `http://localhost:8080/h2-console` (user: `sa`, password: empty, JDBC URL: jdbc:h2:mem:upskillingdb).

**Endpoints principais**
- `GET /api/usuarios` - listar todos usuários
- `GET /api/usuarios/{id}` - buscar usuário por id
- `POST /api/usuarios` - criar usuário
- `PUT /api/usuarios/{id}` - atualizar usuário
- `DELETE /api/usuarios/{id}` - remover usuário

- `GET /api/trilhas` - listar todas trilhas
- `GET /api/trilhas/{id}` - buscar trilha por id
- `POST /api/trilhas` - criar trilha
- `PUT /api/trilhas/{id}` - atualizar trilha
- `DELETE /api/trilhas/{id}` - remover trilha

**Exemplos de payloads**
- Criar usuário (POST /api/usuarios)
```json
{
  "nome": "Ana Silva",
  "email": "ana.silva@example.com",
  "areaAtuacao": "TI",
  "nivelCarreira": "Em transição"
}
```

- Criar trilha (POST /api/trilhas)
```json
{
  "nome": "Introdução à IA",
  "descricao": "Conceitos básicos de IA e aplicações para negócios",
  "nivel": "INICIANTE",
  "cargaHoraria": 40,
  "focoPrincipal": "IA"
}
```

**Seeds**
- Aplicação inclui um `CommandLineRunner` que insere competências, trilhas e usuários iniciais ao subir.

**Testes rápidos (curl)**
```bash
# listar trilhas
curl http://localhost:8080/api/trilhas

# criar usuário
curl -X POST -H "Content-Type: application/json" -d '{"nome":"Teste","email":"t@t.com","areaAtuacao":"Dados","nivelCarreira":"Junior"}' http://localhost:8080/api/usuarios
```

**Observações**
- Arquitetura: Controller → Service → Repository.
- DTOs usados para entrada/saída, e Bean Validation para validação de campos.
- Tratamento centralizado de exceções com `@RestControllerAdvice`.

