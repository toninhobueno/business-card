package github.toninhobueno.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import github.toninhobueno.businesscard.App
import github.toninhobueno.businesscard.R
import github.toninhobueno.businesscard.data.BusinessCard
import github.toninhobueno.businesscard.databinding.ActivityAddBusinessCardBinding
import java.util.*

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }


    private fun insertListeners(){
    binding.btnClose.setOnClickListener{
        finish()
    }

    binding.btnConfirm.setOnClickListener {
        val businessCard = BusinessCard(
            nome = binding.tilName.editText?.text.toString(),
            email = binding.tilEmail.editText?.text.toString(),
            empresa = binding.tilEmpresa.editText?.text.toString(),
            telefone = binding.tilTelefone.editText?.text.toString(),
            fundoPersonalizado = binding.tilCor.editText?.text.toString()
                .uppercase(Locale.getDefault())
        )
        mainViewModel.insert(businessCard)
        Toast.makeText(this, R.string.label_show_success,Toast.LENGTH_SHORT).show()
        finish()
    }
    }
}