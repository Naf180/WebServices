// models/professeur.js
const db = require('../config/db');

class Professeur {
  static create(professeur, callback) {
    const { nom, prenom, email, matiereId, classeId, etudiantId } = professeur;
    db.run(
      'INSERT INTO professeurs (nom, prenom, email, matiereId, classeId, etudiantId) VALUES (?, ?, ?, ?, ?, ?)',
      [nom, prenom, email, matiereId, classeId, etudiantId],
      function (err) {
        if (err) return callback(err);
        callback(null, this.lastID);
      }
    );
  }

  static findAll(callback) {
    db.all('SELECT * FROM professeurs', (err, rows) => {
      if (err) return callback(err);
      callback(null, rows);
    });
  }

  static findById(id, callback) {
    db.get('SELECT * FROM professeurs WHERE id = ?', [id], (err, row) => {
      if (err) return callback(err);
      callback(null, row);
    });
  }

  static update(id, professeur, callback) {
    const { nom, prenom, email, matiereId, classeId, etudiantId } = professeur;
    db.run(
      'UPDATE professeurs SET nom = ?, prenom = ?, email = ?, matiereId = ?, classeId = ?, etudiantId = ? WHERE id = ?',
      [nom, prenom, email, matiereId, classeId, etudiantId, id],
      function (err) {
        if (err) return callback(err);
        callback(null, this.changes);
      }
    );
  }

  static delete(id, callback) {
    db.run('DELETE FROM professeurs WHERE id = ?', [id], function (err) {
      if (err) return callback(err);
      callback(null, this.changes);
    });
  }
}

module.exports = Professeur;