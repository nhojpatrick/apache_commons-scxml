/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.scxml.model;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class StateTest extends TestCase {

    public StateTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(StateTest.class);
    }

    public static void main(String args[]) {
        String[] testCaseName = { StateTest.class.getName()};
        junit.textui.TestRunner.main(testCaseName);
    }
    
    private State state;
    
    public void setUp() {
        state = new State();
    }
    
    public void testGetTransitionsListNull() {
        assertNull(state.getTransitionsList("event"));
    }
    
    public void testGetTransitionsList() {
        List values = new ArrayList();
        
        state.getTransitions().put("event", values);
        
        assertNotNull(state.getTransitionsList("event"));
    }
    
    public void testAddTransitionDoesNotContainKey() {
        Transition transition = new Transition();
        transition.setEvent("event");
        
        state.addTransition(transition);
        
        List events = (List)state.getTransitions().get("event");
        
        assertEquals(1, events.size());
        assertEquals("event", ((Transition)events.get(0)).getEvent());
    }
    
    public void testAddTransitionContainKey() {
        Transition transition1 = new Transition();
        transition1.setEvent("event");

        Transition transition2 = new Transition();
        transition2.setEvent("event");

        state.addTransition(transition1);
        state.addTransition(transition2);
        
        List events = (List)state.getTransitions().get("event");
        
        assertEquals(2, events.size());
    }
    
    public void testGetTransitionList() {
        Transition transition1 = new Transition();
        transition1.setEvent("event");

        Transition transition2 = new Transition();
        transition2.setEvent("event");

        state.addTransition(transition1);
        state.addTransition(transition2);
        
        List events = state.getTransitionsList();
        
        assertEquals(2, events.size());
    }
    
    public void testHasHistoryEmpty() {
        assertFalse(state.hasHistory());
    }

    public void testHasHistory() {
        History history = new History();
        
        state.addHistory(history);
        
        assertTrue(state.hasHistory());
    }
    
    public void testIsSimple() {
        assertTrue(state.isSimple());
    }
    
    public void testIsSimpleParallel() {
        Parallel parallel = new Parallel();
        
        state.setParallel(parallel);
        
        assertFalse(state.isSimple());
    }
    
    public void testIsSimpleHasChildren() {
        State state1 = new State();
        
        state.addChild(state);
        
        assertFalse(state.isSimple());
    }
    
    public void testIsCompositeFalse() {
        assertFalse(state.isComposite());
    }
    
    public void testIsCompositeParallel() {
        Parallel parallel = new Parallel();
        
        state.setParallel(parallel);
        
        assertTrue(state.isComposite());
    }
    
    public void testIsCompositeHasChildren() {
        State state1 = new State();
        
        state.addChild(state);
        
        assertTrue(state.isComposite());
    }
    
    public void testIsRegion() {
        state.setParent(new Parallel());
        
        assertTrue(state.isRegion());
    }
    
    public void testIsRegionNotParallel() {
        state.setParent(new State());
        
        assertFalse(state.isRegion());
    }
    
    public void testIsOrthogonal() {
        Parallel parallel = new Parallel();
        
        state.setParallel(parallel);
        
        assertTrue(state.isOrthogonal());
    }
    
    public void testIsOrthogonalFalse() {
        assertFalse(state.isOrthogonal());
    }

}
