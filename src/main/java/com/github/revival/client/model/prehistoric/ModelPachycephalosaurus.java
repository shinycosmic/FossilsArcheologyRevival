package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.llibrary.common.animation.Animator;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.minecraft.entity.Entity;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelPachycephalosaurus extends ModelPrehistoric
{

    public MowzieModelRenderer leftThigh;
    public MowzieModelRenderer rightThigh;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer upperBody;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer tail3;
    public MowzieModelRenderer leftUpperArm;
    public MowzieModelRenderer rightUpperArm;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer leftLowerArm;
    public MowzieModelRenderer rightLowerArm;
    public MowzieModelRenderer head;
    public MowzieModelRenderer dome1;
    public MowzieModelRenderer hornBumps;
    public MowzieModelRenderer beaklower;
    public MowzieModelRenderer beak;
    public MowzieModelRenderer dome2_l;
    public MowzieModelRenderer dome2_r;
    public MowzieModelRenderer leftLeg;
    public MowzieModelRenderer leftFoot;
    public MowzieModelRenderer rightLeg;
    public MowzieModelRenderer rightFoot;
    public MowzieModelRenderer lowerBody;
	private Animator animator;

    public ModelPachycephalosaurus() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.leftUpperArm = new MowzieModelRenderer(this, 20, 6);
        this.leftUpperArm.setRotationPoint(2.5F, 1.0F, -5.0F);
        this.leftUpperArm.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leftUpperArm, 0.15707963267948966F, -0.0F, 0.0F);
        this.dome1 = new MowzieModelRenderer(this, 0, 11);
        this.dome1.mirror = true;
        this.dome1.setRotationPoint(0.0F, 3.5F, -1.6F);
        this.dome1.addBox(-2.5F, -2.8F, -2.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(dome1, -0.36425021489121656F, -0.0F, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 42, 23);
        this.tail2.setRotationPoint(0.0F, 0.5F, 5.5F);
        this.tail2.addBox(-2.0F, -1.7F, 0.0F, 4, 4, 7, 0.0F);
        this.setRotateAngle(tail2, 0.017453292519943295F, -0.0F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 40, 50);
        this.tail1.setRotationPoint(0.0F, 2.3F, 7.5F);
        this.tail1.addBox(-3.0F, -1.8F, 0.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(tail1, -0.045553093477052F, -0.0F, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 31, 37);
        this.tail3.setRotationPoint(0.0F, 0.1F, 6.5F);
        this.tail3.addBox(-1.5F, -1.3F, 0.0F, 3, 3, 8, 0.0F);
        this.setRotateAngle(tail3, 0.03490658503988659F, -0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 10, 32);
        this.neck.setRotationPoint(0.0F, 0.6F, -5.4F);
        this.neck.addBox(-2.0F, -2.0F, -6.1F, 4, 5, 7, 0.0F);
        this.setRotateAngle(neck, -0.5235987755982988F, -0.0F, 0.0F);
        this.leftThigh = new MowzieModelRenderer(this, 30, 20);
        this.leftThigh.mirror = true;
        this.leftThigh.setRotationPoint(3.0F, 12.0F, -1.0F);
        this.leftThigh.addBox(0.0F, 0.0F, -1.8F, 3, 6, 4, 0.0F);
        this.rightThigh = new MowzieModelRenderer(this, 30, 20);
        this.rightThigh.setRotationPoint(-3.0F, 12.0F, -1.0F);
        this.rightThigh.addBox(-3.0F, 0.0F, -1.8F, 3, 6, 4, 0.0F);
        this.beaklower = new MowzieModelRenderer(this, 28, 15);
        this.beaklower.setRotationPoint(-0.5F, 5.6F, 1.4F);
        this.beaklower.addBox(-1.5F, 0.0F, -3.3F, 3, 1, 3, 0.0F);
        this.setRotateAngle(beaklower, 1.4570008595648662F, 0.0F, 0.0F);
        this.hornBumps = new MowzieModelRenderer(this, 21, 2);
        this.hornBumps.setRotationPoint(-0.5F, 1.1F, -0.6F);
        this.hornBumps.addBox(-3.0F, -1.0F, 0.5F, 6, 2, 2, 0.0F);
        this.setRotateAngle(hornBumps, 2.0943951023931953F, -0.0F, 0.0F);
        this.rightFoot = new MowzieModelRenderer(this, 16, 15);
        this.rightFoot.setRotationPoint(0.1F, 5.5F, 0.5F);
        this.rightFoot.addBox(-2.0F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(rightFoot, 0.2617993877991494F, 0.0F, 0.0F);
        this.rightLowerArm = new MowzieModelRenderer(this, 28, 6);
        this.rightLowerArm.setRotationPoint(-0.9F, 2.5F, -0.5F);
        this.rightLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(rightLowerArm, -0.7291985614832309F, -0.0F, 0.0F);
        this.leftLowerArm = new MowzieModelRenderer(this, 28, 6);
        this.leftLowerArm.mirror = true;
        this.leftLowerArm.setRotationPoint(0.9F, 2.5F, -0.5F);
        this.leftLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(leftLowerArm, -0.7291985614832309F, -0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.5F, -0.5F, -5.4F);
        this.head.addBox(-3.0F, -0.1F, -1.8F, 5, 6, 5, 0.0F);
        this.setRotateAngle(head, -0.8196066167365371F, -0.0F, 0.0F);
        this.leftLeg = new MowzieModelRenderer(this, 0, 25);
        this.leftLeg.setRotationPoint(1.1F, 4.0F, 1.8F);
        this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 3, 0.0F);
        this.setRotateAngle(leftLeg, -0.2617993877991494F, -0.0F, 0.0F);
        this.leftFoot = new MowzieModelRenderer(this, 16, 15);
        this.leftFoot.mirror = true;
        this.leftFoot.setRotationPoint(-0.1F, 5.5F, 0.5F);
        this.leftFoot.addBox(-1.0F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(leftFoot, 0.2617993877991494F, -0.0F, 0.0F);
        this.rightLeg = new MowzieModelRenderer(this, 0, 25);
        this.rightLeg.setRotationPoint(-1.1F, 4.0F, 1.8F);
        this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 3, 0.0F);
        this.setRotateAngle(rightLeg, -0.2617993877991494F, -0.0F, 0.0F);
        this.lowerBody = new MowzieModelRenderer(this, 0, 47);
        this.lowerBody.setRotationPoint(0.0F, 8.6F, -6.5F);
        this.lowerBody.addBox(-3.5F, 0.0F, 0.0F, 7, 8, 8, 0.0F);
        this.setRotateAngle(lowerBody, -0.017453292519943295F, -0.0F, 0.0F);
        this.beak = new MowzieModelRenderer(this, 0, 17);
        this.beak.setRotationPoint(-1.0F, 5.6F, -0.6F);
        this.beak.addBox(-1.5F, -1.1F, -4.4F, 4, 3, 5, 0.0F);
        this.setRotateAngle(beak, 1.6845917940249266F, 0.0F, 0.0F);
        this.rightUpperArm = new MowzieModelRenderer(this, 20, 6);
        this.rightUpperArm.mirror = true;
        this.rightUpperArm.setRotationPoint(-2.5F, 1.0F, -5.0F);
        this.rightUpperArm.addBox(-2.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(rightUpperArm, 0.15707963267948966F, -0.0F, 0.0F);
        this.dome2_l = new MowzieModelRenderer(this, 0, 11);
        this.dome2_l.mirror = true;
        this.dome2_l.setRotationPoint(0.0F, 4.0F, -0.5F);
        this.dome2_l.addBox(-1.51F, -2.0F, -2.8F, 3, 4, 2, 0.0F);
        this.setRotateAngle(dome2_l, 0.5918411493512771F, -0.0F, 0.0F);
        this.upperBody = new MowzieModelRenderer(this, 39, 0);
        this.upperBody.setRotationPoint(0.0F, 2.2F, 1.0F);
        this.upperBody.addBox(-2.5F, -2.0F, -6.0F, 5, 7, 6, 0.0F);
        this.setRotateAngle(upperBody, 0.05585053606381855F, -0.0F, 0.0F);
        this.dome2_r = new MowzieModelRenderer(this, 0, 11);
        this.dome2_r.setRotationPoint(0.0F, 4.0F, -0.5F);
        this.dome2_r.addBox(-2.49F, -2.0F, -2.8F, 3, 4, 2, 0.0F);
        this.setRotateAngle(dome2_r, 0.5918411493512771F, -0.0F, 0.0F);
        this.upperBody.addChild(this.leftUpperArm);
        this.head.addChild(this.dome1);
        this.tail1.addChild(this.tail2);
        this.lowerBody.addChild(this.tail1);
        this.tail2.addChild(this.tail3);
        this.upperBody.addChild(this.neck);
        this.head.addChild(this.beaklower);
        this.head.addChild(this.hornBumps);
        this.rightLeg.addChild(this.rightFoot);
        this.rightUpperArm.addChild(this.rightLowerArm);
        this.leftUpperArm.addChild(this.leftLowerArm);
        this.neck.addChild(this.head);
        this.leftThigh.addChild(this.leftLeg);
        this.leftLeg.addChild(this.leftFoot);
        this.rightThigh.addChild(this.rightLeg);
        this.head.addChild(this.beak);
        this.upperBody.addChild(this.rightUpperArm);
        this.head.addChild(this.dome2_l);
        this.lowerBody.addChild(this.upperBody);
        this.head.addChild(this.dome2_r);
        this.setInitPose();
		animator = new Animator(this);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animate((IAnimated)entity, f, f1, f2, f3, f4, f5);
        this.leftThigh.render(f5);
        this.rightThigh.render(f5);
        this.lowerBody.render(f5);
	}
    
    public void animate(IAnimated entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animator.update(entity);
		this.setToInitPose();
		setRotationAngles(f, f1, f2, f3, f4, f5, (Entity)entity);
	}
    
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	MowzieModelRenderer[] tailParts = {this.tail1, this.tail2, this.tail3};
		MowzieModelRenderer[] neckParts = {this.neck, this.head};
		MowzieModelRenderer[] leftArmParts = {this.leftUpperArm, this.leftLowerArm};
		MowzieModelRenderer[] rightArmParts = {this.rightUpperArm, this.rightLowerArm};
		this.faceTarget(head, 1, f3, f4);
		float speed = 0.1F;
		float speed2 = 0.8F;
		float sitProgress = ((EntityNewPrehistoric)(entity)).sitProgress;
		this.walk(upperBody, speed, 0.1F, false, 1F, 0F, entity.ticksExisted, 1);
		this.bob(lowerBody, speed, 0.7F, false, entity.ticksExisted, 1);
		this.walk(leftThigh, speed2, 0.8F, false, 0F, 0.4F, f, f1);
		this.walk(leftLeg, speed2, 0.2F, false, 0F, -0.6F, f, f1);
		this.walk(leftFoot, speed2, -0.8F, true, 0.3F, 0.4F, f, f1);
		this.walk(rightThigh, speed2, 0.8F, true, 0F, 0.4F, f, f1);
		this.walk(rightLeg, speed2, 0.2F, true, 0F, -0.6F, f, f1);
		this.walk(rightFoot, speed2, -0.8F, false, 0.3F, 0.4F, f, f1);
		this.chainWave(tailParts, speed, 0.05F, -3, entity.ticksExisted, 1);
		this.chainWave(leftArmParts, speed, 0.15F, -3, entity.ticksExisted, 1);
		this.chainWave(rightArmParts, speed, 0.15F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed, 0.15F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed2, 0.25F, -3, f, f1);
		this.chainWave(neckParts, speed, 0.15F, 3, entity.ticksExisted, 1);
    }
}
