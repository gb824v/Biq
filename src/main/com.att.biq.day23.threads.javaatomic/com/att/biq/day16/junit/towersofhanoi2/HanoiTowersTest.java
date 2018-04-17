package com.att.biq.day16.junit.towersofhanoi2;
import org.junit.Test;

import com.att.biq.day16.junit.towersofhanoi2.HanoiTowers.Peg;

import static org.junit.Assert.assertArrayEquals;
 
public class HanoiTowersTest {
 
    private static final Integer[] EMPTY = {};
    private static final Integer[] ONE_DISK = {1};
    private static final Integer[] THREE_DISKS = {1, 2, 3};
    private static final Integer[] FIVE_DISKS = {1, 2, 3, 4, 5};
    private static final Integer[] TWENTY_DISKS
            = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
 
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNegativePegs() {
        new HanoiTowers(-1);
    }
 
    @Test
    public void shouldInitializePegsWithGivenNumberOfDisks() {
        HanoiTowers hanoi = new HanoiTowers(0);
        assertPegs(hanoi, EMPTY, EMPTY, EMPTY);
 
        hanoi = new HanoiTowers(1);
        assertPegs(hanoi, ONE_DISK, EMPTY, EMPTY);
 
        hanoi = new HanoiTowers(5);
        assertPegs(hanoi, FIVE_DISKS, EMPTY, EMPTY);
    }
 
    @Test
    public void shouldDoNothingWithEmptyPegs() {
        HanoiTowers hanoi = new HanoiTowers(0);
        hanoi.solve(Peg.A, Peg.B);
        assertPegs(hanoi, EMPTY, EMPTY, EMPTY);
    }
 
    @Test
    public void shouldMoveTheOnlyDiskToSelectedPeg() {
        HanoiTowers hanoi = new HanoiTowers(1);
        hanoi.solve(Peg.A, Peg.B);
        assertPegs(hanoi, EMPTY, ONE_DISK, EMPTY);
 
        hanoi.solve(Peg.B, Peg.C);
        assertPegs(hanoi, EMPTY, EMPTY, ONE_DISK);
 
        hanoi.solve(Peg.C, Peg.A);
        assertPegs(hanoi, ONE_DISK, EMPTY, EMPTY);
    }
 
    @Test
    public void shouldMoveAllDisksToSelectedPeg() {
        HanoiTowers hanoi = new HanoiTowers(3);
        hanoi.solve(Peg.A, Peg.C);
        assertPegs(hanoi, EMPTY, EMPTY, THREE_DISKS);
 
        hanoi = new HanoiTowers(5);
        hanoi.solve(Peg.A, Peg.C);
        assertPegs(hanoi, EMPTY, EMPTY, FIVE_DISKS);
 
        hanoi = new HanoiTowers(20);
        hanoi.solve(Peg.A, Peg.C);
        assertPegs(hanoi, EMPTY, EMPTY, TWENTY_DISKS);
    }
 
    private void assertPegs(HanoiTowers hanoi, Integer[] pegA,
                            Integer[] pegB, Integer[] pegC) {
        assertPeg(hanoi, Peg.A, pegA);
        assertPeg(hanoi, Peg.B, pegB);
        assertPeg(hanoi, Peg.C, pegC);
    }
 
    private void assertPeg(HanoiTowers hanoi, Peg peg,
                           Integer[] actual) {
        assertArrayEquals(hanoi.toString(),
                hanoi.peg(peg), actual);
    }
}