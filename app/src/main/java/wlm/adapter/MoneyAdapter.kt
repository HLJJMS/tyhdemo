package wlm.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import wlm.base.MoneyBean
import wlm.tyhkj.R

class MoneyAdapter :
        BaseQuickAdapter<MoneyBean.ValueDTO.ListDTO, BaseViewHolder>(R.layout.item_main) {
    override fun convert(holder: BaseViewHolder, item: MoneyBean.ValueDTO.ListDTO) {
        holder.setText(R.id.txt,item.lotteryDrawResult)
    }

}