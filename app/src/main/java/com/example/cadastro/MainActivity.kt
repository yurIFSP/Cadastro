package com.example.cadastro

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Formulario(
    var nomeCompleto: String = "",
    var telefone: String = "",
    var email: String = "",
    var ingressarListaEmails: Boolean = false,
    var sexo: String = "",
    var cidade: String = "",
    var uf: String = ""
) {
    override fun toString(): String {
        return "Nome Completo: $nomeCompleto\nTelefone: $telefone\nE-mail: $email\nIngressar na lista de e-mails: $ingressarListaEmails\nSexo: $sexo\nCidade: $cidade\nUF: $uf"
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomeCompletoEditText: EditText = findViewById(R.id.nomeCompletoEditText)
        val telefoneEditText: EditText = findViewById(R.id.telefoneEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val ingressarListaCheckBox: CheckBox = findViewById(R.id.ingressarListaCheckBox)
        val sexoRadioGroup: RadioGroup = findViewById(R.id.sexoRadioGroup)
        val cidadeEditText: EditText = findViewById(R.id.cidadeEditText)
        val ufSpinner: Spinner = findViewById(R.id.ufSpinner)
        val limparButton: Button = findViewById(R.id.limparButton)
        val salvarButton: Button = findViewById(R.id.salvarButton)

        val ufOptions = arrayOf("Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO")
        val ufAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ufOptions)
        ufAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ufSpinner.adapter = ufAdapter

        limparButton.setOnClickListener {
            nomeCompletoEditText.text.clear()
            telefoneEditText.text.clear()
            emailEditText.text.clear()
            ingressarListaCheckBox.isChecked = false
            sexoRadioGroup.clearCheck()
            cidadeEditText.text.clear()
            ufSpinner.setSelection(0)
        }

        salvarButton.setOnClickListener {
            val nomeCompleto = nomeCompletoEditText.text.toString()
            val telefone = telefoneEditText.text.toString()
            val email = emailEditText.text.toString()
            val ingressarLista = ingressarListaCheckBox.isChecked
            val sexo = findViewById<RadioButton>(sexoRadioGroup.checkedRadioButtonId)?.text.toString()
            val cidade = cidadeEditText.text.toString()
            val uf = ufSpinner.selectedItem.toString()

            val formulario = Formulario(nomeCompleto, telefone, email, ingressarLista, sexo, cidade, uf)
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }
    }
}