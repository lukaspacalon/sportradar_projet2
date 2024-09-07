const apiUrl = 'http://localhost:8080'; // Update with your backend API URL if needed

function startGame() {
    const homeTeam = document.getElementById('homeTeam').value;
    const awayTeam = document.getElementById('awayTeam').value;

    fetch(`${apiUrl}/startGame`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ homeTeam, awayTeam })
    }).then(response => response.json())
      .then(data => alert(data.message));
}

function updateScore() {
    const homeTeam = document.getElementById('updateHomeTeam').value;
    const awayTeam = document.getElementById('updateAwayTeam').value;
    const homeScore = parseInt(document.getElementById('homeScore').value);
    const awayScore = parseInt(document.getElementById('awayScore').value);

    fetch(`${apiUrl}/updateScore`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ homeTeam, awayTeam, homeScore, awayScore })
    }).then(response => response.json())
      .then(data => alert(data.message));
}

function finishGame() {
    const homeTeam = document.getElementById('finishHomeTeam').value;
    const awayTeam = document.getElementById('finishAwayTeam').value;

    fetch(`${apiUrl}/finishGame`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ homeTeam, awayTeam })
    }).then(response => response.json())
      .then(data => alert(data.message));
}

function getSummary() {
    fetch(`${apiUrl}/getSummary`)
        .then(response => response.json())
        .then(data => {
            const summaryList = document.getElementById('summaryList');
            summaryList.innerHTML = '';
            data.forEach(game => {
                const li = document.createElement('li');
                li.textContent = `${game.homeTeam} ${game.homeScore} - ${game.awayScore} ${game.awayTeam}`;
                summaryList.appendChild(li);
            });
        });
}
