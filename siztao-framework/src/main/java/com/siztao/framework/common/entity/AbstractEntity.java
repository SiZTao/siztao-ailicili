package com.siztao.framework.common.entity;

import com.siztao.framework.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @项目名称: siztao-ailicili
 * @模块名称:
 * @类名称:
 * @类描述:
 * @创建人: SiZhenTao
 * @创建时间: 2018-03-18 20:47
 * @修改人: SiZhenTao
 * @修改时间: 2018-03-18 20:47
 * @email: 982637685@qq.com
 * @version:
 **/
@SuppressWarnings("serial")
public abstract class AbstractEntity<ID> extends BaseEntity {

    public abstract ID getId();

    public abstract void setId(ID id);

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Persistable#isNew()
     *
     */
    public boolean isNew() {

        return null == getId();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        @SuppressWarnings("unchecked")
        AbstractEntity<ID> that = (AbstractEntity<ID>) obj;

        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
