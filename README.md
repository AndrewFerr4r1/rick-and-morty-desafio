<h1>Consumindo api do rick and morty</h1>

<h2>Package Config</h2>

<p>No pacote config temos uma classe config onde tem a conexão com a api, existem dois métodos que um usa para dá um get all e outro um filtro por nome, tem outros dois que são para tratamento do json para pegar somente os dados necessarios</p>

<h2>Package Utils</h2>

<p>No pacote utils temos uma classe utils que existem dois métodos os dois são para gerar txt, a diferença que um gera para somente uma localização e o outro gera para todas as localizações em txt, na classe PilhaObj é focada para pegar o resultado do json e colocar ele numa lista em forma de pilha para depois jogar no txt</p>

<h2>Package Model</h2>

<p>No package Model temos a LocationRecord que é usada somente para pegar os atributos do json que eu desejo, na classe Location ali estão os atributos com o construtor e os get e setters para consumir</p>

<h2>Classe main</h2>

<p>é uma classe executavel onde você pode visualizar a aplicação funcionando, onde tem as opçôes de pesquisar por nome da localização ou pegar todas e guardar em um txt</p>
