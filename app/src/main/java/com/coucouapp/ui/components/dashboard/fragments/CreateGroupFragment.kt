package com.coucouapp.ui.components.dashboard.fragments

import android.app.*
import android.content.*
import android.graphics.*
import android.graphics.drawable.*
import android.os.*
import android.view.*
import androidx.databinding.*
import com.coucouapp.*
import com.coucouapp.databinding.*
import com.coucouapp.ui.base.*
import com.coucouapp.ui.components.*
import com.coucouapp.ui.components.dashboard.viewmodel.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CreateGroupFragment : BaseFragment<DashboardViewModel, FragmentCreateGroupBinding>(),
    View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var createGroupBinding: FragmentCreateGroupBinding
    
    override fun getLayout(): Int = R.layout.fragment_create_group
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        createGroupBinding = FragmentCreateGroupBinding.inflate(inflater, container, false)
        return createGroupBinding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createGroupBinding.btCreateGroup.setOnClickListener(this)
    }
    
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    
    
    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }
    
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bt_create_group -> {
                showDialog()
            }
        }
    }
    
    private fun showDialog() {
        var dialog = Dialog(requireActivity())
        val binding: DialogCreateGroupBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_create_group,
            null,
            false
        )
        dialog.setContentView(binding.getRoot())
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.getWindow()?.setLayout(width, height)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.btYes.setOnClickListener {
            var intent = Intent(requireActivity(), CreateGroupVerificationActivity::class.java)
            startActivity(intent)
            dialog.dismiss()
        }
        binding.btCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
    
}