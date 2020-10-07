package com.paladin.account.entity;
import java.time.LocalDateTime;
import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 专题评论表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="TopicComment对象", description="专题评论表")
public class TopicComment extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private String memberNickName;

    private Long topicId;

    private String memberIcon;

    private String content;

    private LocalDateTime createTime;

    private Integer showStatus;

}
