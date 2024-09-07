// frontend/script.test.js
import '@testing-library/jest-dom/extend-expect';
import { render, screen, fireEvent } from '@testing-library/react';
import userEvent from '@testing-library/user-event';

// Mock fetch to simulate API responses
global.fetch = jest.fn((url, options) => {
  if (url.endsWith('/startGame')) {
    return Promise.resolve({ json: () => Promise.resolve({ message: 'Game started' }) });
  } else if (url.endsWith('/updateScore')) {
    return Promise.resolve({ json: () => Promise.resolve({ message: 'Score updated' }) });
  } else if (url.endsWith('/finishGame')) {
    return Promise.resolve({ json: () => Promise.resolve({ message: 'Game finished' }) });
  } else if (url.endsWith('/getSummary')) {
    return Promise.resolve({ json: () => Promise.resolve([]) });
  }
  return Promise.reject('Unknown endpoint');
});

test('should start a new game', async () => {
  // Set up the DOM
  document.body.innerHTML = `
    <input type="text" id="homeTeam" placeholder="Home Team">
    <input type="text" id="awayTeam" placeholder="Away Team">
    <button onclick="startGame()">Start Game</button>
  `;

  // Mock function call
  const startGame = require('./script').startGame;
  startGame();

  // Check the fetch call
  expect(global.fetch).toHaveBeenCalledWith('http://localhost:8080/startGame', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ homeTeam: '', awayTeam: '' }),
  });
});

test('should update the score', async () => {
    document.body.innerHTML = `
      <input type="text" id="updateHomeTeam" placeholder="Home Team">
      <input type="text" id="updateAwayTeam" placeholder="Away Team">
      <input type="number" id="homeScore" placeholder="Home Score">
      <input type="number" id="awayScore" placeholder="Away Score">
      <button onclick="updateScore()">Update Score</button>
    `;
  
    const updateScore = require('./script').updateScore;
    updateScore();
  
    expect(global.fetch).toHaveBeenCalledWith('http://localhost:8080/updateScore', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ homeTeam: '', awayTeam: '', homeScore: 0, awayScore: 0 }),
    });
  });

  test('should display summary', async () => {
    document.body.innerHTML = `
      <button onclick="getSummary()">Get Summary</button>
      <ul id="summaryList"></ul>
    `;
  
    const getSummary = require('./script').getSummary;
    await getSummary();
  
    // Assuming the summaryList is empty for this test
    const summaryList = document.getElementById('summaryList');
    expect(summaryList.children.length).toBe(0);
  });
  

