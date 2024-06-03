# Projeto Programação Orientada a Objetos

    Considere que se pretende criar uma aplicação que faça a gestão das actividades e planos de treino, de praticantes de actividades físicas. A aplicação deverá considerar a existência de diversas actividades quepodem ser praticadas (exemplo: corrida, bicicleta, pilates, levantamento de pesos, etc.), por diversos tipos de atletas (ex: profissionais, amadores, praticantes ocasionais, etc.). Deverá também ser possível registar um plano de treinos para determinado utilizador indicando quais são as actividades a realizar. O objectivo da aplicação será o de permitir para cada utilizador registar a realização das actividades, permitindo depois obter uma série de indicadores relativos ao treino de cada um. Um segundo objectivo, mais elaborado e complexo, consistirá na geração de um plano de treino para um determinado utilizador de acordo com os objectivos deste em termos de tipo de exercício e de quantidade esperada de calorias gastas.
    
    A aplicação deverá permitir registar que uma determinada actividade foi realizada por um determinado
utilizador, associando a data e hora da realização, e será possível obter posteriormente informação relativa
ao número de calorias consumidas num determinado período, ao número de kms percorridos num período,
ao número de metros de altimetria acumulados num determinado período, entre outra informação que se
julgue relevante.

    A aplicação deverá ter também a noção de plano de treino de um utilizador, que não é mais do que uma colecção de exercícios que efectua numa sessão de treino e a indicação dos dias da semana em que faz esses mesmos exercícios e da recorrência com que os faz (ex: todos os dias, todas as segundas e quintas, etc.).

    Um aspecto que é importante ter em linha de conta é que, para que o sistema possa ser simulado o mais
possível num cenário de utilização real, será necessário efectuar saltos no tempo. Isto é, a aplicação deverá
saber em que data é que se encontra e deverá estar explicíta uma funcionalidade que permitirá avançar para
uma data no futuro. O avançar do tempo (simulado por questões práticas e de redução de complexidade)
deverá originar todas as acções pendentes à realização das actividades que estejam programadas.


## Instalação

Dentro da pasta onde se encontra o projeto:
- javac -d bin src/*.java src/users/*.java src/activities/*.java 
- java -cp bin Main
